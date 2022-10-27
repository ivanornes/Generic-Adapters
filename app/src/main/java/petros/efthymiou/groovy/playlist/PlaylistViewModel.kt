package petros.efthymiou.groovy.playlist

import androidx.lifecycle.*
import kotlinx.coroutines.flow.onEach
import petros.efthymiou.groovy.common.RecyclerViewAdapterCellController


class PlaylistViewModel(
    private val repository: PlaylistRepository
) : ViewModel() {

    val loader = MutableLiveData<Boolean>()

    val playlists = liveData<Result<List<Playlist>>> {
        loader.postValue(true)

        emitSource(repository.getPlaylists()
            .onEach {
                loader.postValue(false)
            }
            .asLiveData())
    }

    val playlistCellControllers = playlists.map {
        if (it.isSuccess) {
            it.getOrNull()!!.map {
                val adapter = PlaylistCellControllerAdapter(it)
                val celController = PlaylistCellController(adapter.getViewModel()) {
                    // Click
                }
                RecyclerViewAdapterCellController(
                    adapter.getId(),
                    adapter.getHash(),
                    adapter.getViewHolderType(),
                    celController)
            }
        } else {
            emptyList()
        }
    }
}

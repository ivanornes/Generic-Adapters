package petros.efthymiou.groovy.playlist

class PlaylistCellControllerAdapter(
    private val playlist: Playlist
) {
    fun getId() : String {
        return playlist.id
    }

    fun getHash() : String {
        return playlist.hashCode().toString()
    }

    fun getViewHolderType() : Int {
        return PlaylistViewHolderType.PLAYLIST.viewHolderType()
    }

    fun getViewModel() : PlaylistCellViewModel {
        return PlaylistCellViewModel(
            playlist.name,
            playlist.category,
            playlist.image)
    }
}
package petros.efthymiou.groovy.playlist

enum class PlaylistViewHolderType {
    PLAYLIST, ALBUM;

    companion object {
        fun typeFor(value: Int) : PlaylistViewHolderType {
            return when (value) {
                0 -> PLAYLIST
                1 -> ALBUM
                else -> { throw Exception("Unknown type") }
            }
        }
    }

    fun viewHolderType() : Int {
        return when (this) {
            PLAYLIST -> 0
            ALBUM -> 1
        }
    }
}
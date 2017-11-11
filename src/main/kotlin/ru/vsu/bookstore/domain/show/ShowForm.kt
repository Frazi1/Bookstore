package ru.vsu.bookstore.domain.show

import ru.vsu.bookstore.domain.genre.Genre
import java.io.Serializable

data class ShowForm(
        var name: String = "",
        var dayOfWeek: Int = 0,
        var startTime: String = "00:00",
        var hours: String = "0",
        var minutes: String = "0",
        var genreName: String = ""
) : Serializable {
    fun getShow(allGenres: List<Genre>): Show =
            Show(
                    name,
                    dayOfWeek,
                    getMinutes(startTime).toLong(),
                    hours.toLong() * 60 + minutes.toLong(),
                    allGenres.find { it.name == genreName }
            )

    fun getMinutes(time: String): Int =
            time.substring(0, 2).toInt() * 60 + time.substring(3, 5).toInt()
}
package com.example.moviesbrowser.ui.home.data

import com.example.moviesbrowser.R
import com.example.moviesbrowser.ui.details.data.Actor

data class Movie (
    val id:String,
    val title: String,
    val thumbnail: Int,
    val description: String = "",
    val scenesImages: List<Int>,
    val actorsList: List<Actor>
)

val movies = listOf(
    Movie(
        id = "1",
        title = "Joker",
        thumbnail = R.drawable.joker1,
        description = "Arthur Fleck (Joaquin Phoenix) jest niezauważanym przez nikogo komikiem, który nieustannie próbuje odnaleźć się w Gotham City. Gdy jednak w wyniku serii niefortunnych zdarzeń jego życie osobiste, zawodowe i społeczne zaczyna się rozpadać, a miasto pogrąża się w chaosie, Fleck postanawia zaryzykować i podjąć ostateczną próbę odnalezienia się w społeczeństwie.",
        scenesImages = listOf(
            R.drawable.joker1
        ),
        actorsList = listOf(
            Actor(
                id = "1",
                name = "Joaquin Phoenix",
                image = 0
            ),
        )


    ),

)
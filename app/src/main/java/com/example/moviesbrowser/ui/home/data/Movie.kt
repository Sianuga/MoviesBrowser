package com.example.moviesbrowser.ui.home.data

import com.example.moviesbrowser.R
import com.example.moviesbrowser.ui.details.data.Actor
import com.example.moviesbrowser.ui.details.data.actors

data class Movie (
    val id:Int,
    val title: String,
    val thumbnail: Int,
    val description: String = "",
    val scenesImages: List<Int>,
    val actorsList: List<Actor>,
    val videosList: List<Int>
)

val movies = listOf(

    Movie(
        id = 1,
        title = "Na rauszu",
        thumbnail = R.drawable.druk_thumbnail,
        description = "Czwórka nauczycieli pracujących w gimnazjum testuje alkoholową metodę, która ma polepszyć jakość ich życia.",
        scenesImages = listOf(
            R.drawable.druk1,
            R.drawable.druk2,
            R.drawable.druk3,
            R.drawable.druk4,
        )
        ,
        actorsList = listOf(
            actors[12],
            actors[13],
            actors[14],
            actors[15]
        ),

        videosList = listOf(
            R.raw.druk_movie1
        ),
    ),
    Movie(
        id = 2,
        title = "Midsommar",
        thumbnail = R.drawable.midsommar_thumbnail,
        description = "Młoda para w czasie wakacji odwiedza odizolowaną od świata szwedzką wioskę. Wkrótce dowiaduje się o ekscentrycznych miejscowych tradycjach.",
        scenesImages = listOf(
            R.drawable.midsommar1,
            R.drawable.midsommar2,
            R.drawable.midsommar3,
            R.drawable.midsommar4,
        ),
        actorsList = listOf(
            actors[8],
            actors[9],
            actors[10],
            actors[11]
        ),
        videosList = listOf(
            R.raw.midsommar1,
            R.raw.midsommar2,
        ),
    ),

    Movie(
        id = 3,
        title = "Joker",
        thumbnail = R.drawable.joker_thumbnail,
        description = "Arthur Fleck (Joaquin Phoenix), strudzony życiem komik popada w obłęd i staje się psychopatycznym mordercą.",
        scenesImages = listOf(
            R.drawable.joker1,
            R.drawable.joker2,
            R.drawable.joker3,
            R.drawable.joker4,

            ),
        actorsList = listOf(
            actors[0],
            actors[1],
            actors[2],
            actors[3]
        ),

        videosList = listOf(
            R.raw.joker1
        ),

    ),
    Movie(
        id = 4,
        title = "American Psycho",
        thumbnail = R.drawable.american_thumbnail,
        description = "Adaptacja powieści Breta Eastona Ellisa. Patrick Bateman to typowy amerykański yuppie, który zaczyna mordować ludzi, chcąc oderwać się od rutyny.",
        scenesImages = listOf(
            R.drawable.american1,
            R.drawable.american2,
            R.drawable.american3,
            R.drawable.american4,

            ),
        actorsList = listOf(
            actors[4],
            actors[5],
            actors[6],
            actors[7]
        ),

        videosList = listOf(
            R.raw.american_psycho1,

        ),
    ),
    Movie(
        id = 5,
        title = "Avengers: Koniec gry",
        thumbnail = R.drawable.avengers_thumbnail,
        description = "Po wymazaniu połowy życia we Wszechświecie przez Thanosa Avengersi starają się zrobić wszystko, co konieczne, aby pokonać szalonego tytana.",
        scenesImages = listOf(
            R.drawable.avengers1,
            R.drawable.avengers2,
            R.drawable.avengers3,
            R.drawable.avengers4,
        ),
        actorsList = listOf(
            actors[16],
            actors[17],
            actors[18],
            actors[19]
        ),

        videosList = listOf(
            R.raw.avengers1,
            R.raw.avengers2,
        ),
    ),


)
package ru.timcock.mayday.data.requests

data class AddDreamRequest(val email: String, val text: String,
                           val data_time: String, val img: String, val authedEmail: String)

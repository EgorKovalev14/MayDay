package ru.timcock.mayday.data.requests

data class AddSovetRequest(val text_head: String, val text: String,
    val tag: String, val img: String, val authedEmail: String)

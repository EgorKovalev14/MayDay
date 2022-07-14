package ru.timcock.mayday.data.requests

data class AddNoteRequest(val email: String, val text: String, val text_head: String
                          , val authedEmail: String)

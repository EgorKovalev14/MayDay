package ru.timcock.mayday.data.requests

data class AddGoalRequest(val email: String, val tag: String,
                          val data_time: String, val end_date: String, val authedEmail: String)

package ru.timcock.mayday.data

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.timcock.mayday.data.requests.*
import java.util.ArrayList

class RequestsRealisation {
    companion object {
        private fun auth(req: AuthRequest, context: Context) {
            RequestBuilder.buildService()
                .auth(req)
                .enqueue(object: Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }
                })
        }


        private fun registrate(req: RegistrateRequest, context: Context) {
            RequestBuilder.buildService()
                .registrate(req)
                .enqueue(object: Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }
                })
        }

        private fun addDream(addDreamRequest: AddDreamRequest, context: Context) {
            RequestBuilder.buildService()
                .addDream(addDreamRequest)
                .enqueue(object: Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }
                })
        }

        private fun deleteDream(deleteDreamRequest: DeleteDreamRequest, context: Context) {
            RequestBuilder.buildService()
                .deleteDream(deleteDreamRequest)
                .enqueue(object: Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }
                })
        }

        private fun getDreams(getSomeRequest: GetSomeRequest, context: Context) {
            RequestBuilder.buildService()
                .getDreams(getSomeRequest)
                .enqueue(object: Callback<ArrayList<Dream>> {
                    override fun onResponse(call: Call<ArrayList<Dream>>, response: Response<ArrayList<Dream>>) {

                    }

                    override fun onFailure(call: Call<ArrayList<Dream>>, t: Throwable) {

                    }
                })
        }

        private fun addGoal(addGoalRequest: AddGoalRequest, context: Context) {
            RequestBuilder.buildService()
                .addGoal(addGoalRequest)
                .enqueue(object: Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }
                })
        }

        private fun deleteGoal(deleGoalRequest: DeleteGoalRequest, context: Context) {
            RequestBuilder.buildService()
                .deleteGoal(deleGoalRequest)
                .enqueue(object: Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }
                })
        }

        private fun getGoals(getSomeRequest: GetSomeRequest, context: Context) {
            RequestBuilder.buildService()
                .getGoals(getSomeRequest)
                .enqueue(object: Callback<ArrayList<Goal>> {
                    override fun onResponse(call: Call<ArrayList<Goal>>, response: Response<ArrayList<Goal>>) {

                    }

                    override fun onFailure(call: Call<ArrayList<Goal>>, t: Throwable) {

                    }
                })
        }

        private fun addSovet(addSovetRequest: AddSovetRequest, context: Context) {
            RequestBuilder.buildService()
                .addSovet(addSovetRequest)
                .enqueue(object: Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }
                })
        }

        private fun deleteSovet(deleteSovetRequest: DeleteSovetRequest, context: Context) {
            RequestBuilder.buildService()
                .deleteSovet(deleteSovetRequest)
                .enqueue(object: Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }
                })
        }

        private fun getSovet(getSomeRequest: GetSomeRequest, context: Context) {
            RequestBuilder.buildService()
                .getSovets(getSomeRequest)
                .enqueue(object: Callback<ArrayList<Sovet>> {
                    override fun onResponse(call: Call<ArrayList<Sovet>>, response: Response<ArrayList<Sovet>>) {

                    }

                    override fun onFailure(call: Call<ArrayList<Sovet>>, t: Throwable) {

                    }
                })
        }

        private fun addNote(addNoteRequest: AddNoteRequest, context: Context) {
            RequestBuilder.buildService()
                .addNote(addNoteRequest)
                .enqueue(object: Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }
                })
        }

        private fun deleteNote(deleNoteRequest: DeleteNoteRequest, context: Context) {
            RequestBuilder.buildService()
                .deleteNote(deleNoteRequest)
                .enqueue(object: Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }
                })
        }

        private fun getNotes(getSomeRequest: GetSomeRequest, context: Context) {
            RequestBuilder.buildService()
                .getNotes(getSomeRequest)
                .enqueue(object: Callback<ArrayList<Note>> {
                    override fun onResponse(call: Call<ArrayList<Note>>, response: Response<ArrayList<Note>>) {

                    }

                    override fun onFailure(call: Call<ArrayList<Note>>, t: Throwable) {

                    }
                })
        }
    }
}
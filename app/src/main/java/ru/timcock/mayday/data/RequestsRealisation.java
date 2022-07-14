package ru.timcock.mayday.data;

import android.content.Context;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.timcock.mayday.data.requests.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

class RequestsRealisation {
    private void auth(AuthRequest req, Context context) {
        RequestBuilder.buildService()
                .auth(req)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
    }

    private void registrate(RegistrateRequest req, Context context) {
        RequestBuilder.buildService()
                .registrate(req)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
    }

    private void addDream(AddDreamRequest addDreamRequest, Context context) {
        RequestBuilder.buildService()
                .addDream(addDreamRequest)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
    }

    private void deleteDream(DeleteSomeRequest deleteDreamRequest, Context context) {
        RequestBuilder.buildService()
                .deleteDream(deleteDreamRequest)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
    }

    private void getDreams(GetSomeRequest getSomeRequest, Context context) {
        RequestBuilder.buildService()
                .getDreams(getSomeRequest)
                .enqueue(new Callback<ArrayList<Dream>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Dream>> call, Response<ArrayList<Dream>> response) {

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Dream>> call, Throwable t) {

                    }
                });
    }

    private void addGoal(AddGoalRequest addGoalRequest, Context context) {
        RequestBuilder.buildService()
                .addGoal(addGoalRequest)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
    }

    private void deleteGoal(DeleteSomeRequest deleGoalRequest, Context context) {
        RequestBuilder.buildService()
                .deleteGoal(deleGoalRequest)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
    }

    private void getGoals(GetSomeRequest getSomeRequest, Context context) {
        RequestBuilder.buildService()
                .getGoals(getSomeRequest)
                .enqueue(new Callback<ArrayList<Goal>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Goal>> call, Response<ArrayList<Goal>> response) {

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Goal>> call, Throwable t) {

                    }
                });
    }

    private void getSovet(GetSomeRequest getSomeRequest, Context context) {
        RequestBuilder.buildService()
                .getSovets(getSomeRequest)
                .enqueue(new Callback<ArrayList<Sovet>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Sovet>> call, Response<ArrayList<Sovet>> response) {

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Sovet>> call, Throwable t) {

                    }
                });
    }

    private void addNote(AddNoteRequest addNoteRequest, Context context) {
        RequestBuilder.buildService()
                .addNote(addNoteRequest)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
    }

    private void deleteNote(DeleteSomeRequest deleNoteRequest, Context context) {
        RequestBuilder.buildService()
                .deleteNote(deleNoteRequest)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
    }

    private void getNotes(GetSomeRequest getSomeRequest, Context context) {
        RequestBuilder.buildService()
                .getNotes(getSomeRequest)
                .enqueue(new Callback<ArrayList<Note>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Note>> call, Response<ArrayList<Note>> response) {

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Note>> call, Throwable t) {

                    }
                });
    }
}

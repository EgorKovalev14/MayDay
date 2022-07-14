package ru.timcock.mayday.data;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.*;
import ru.timcock.mayday.data.requests.*;

public interface RequestsInterface {
    @POST("api/users")
    public Call<Void> auth(@Body AuthRequest body);

    @POST("api/registrate")
    public Call<Void> registrate(@Body RegistrateRequest body);

    @POST("api/dreams/add")
    public Call<Void> addDream(@Body AddDreamRequest body);

    @POST("api/dreams/delete")
    public Call<Void> deleteDream(@Body DeleteDreamRequest body);

    @GET("api/dreams/get")
    public Call<ArrayList<Dream>> getDreams(@Body GetSomeRequest body);

    @POST("api/goals/add")
    public Call<Void> addGoal(@Body AddGoalRequest body);

    @POST("api/goals/delete")
    public Call<Void> deleteGoal(@Body DeleteGoalRequest body);

    @GET("api/goals/get")
    public Call<ArrayList<Goal>> getGoals(@Body GetSomeRequest body);

    @POST("api/sovets/add")
    public Call<Void> addSovet(@Body AddSovetRequest body);

    @POST("api/sovets/delete")
    public Call<Void> deleteSovet(@Body DeleteSovetRequest body);

    @GET("api/sovets/get")
    public Call<ArrayList<Sovet>> getSovets(@Body GetSomeRequest body);

    @POST("api/notes/add")
    public Call<Void> addNote(@Body AddNoteRequest body);

    @POST("api/notes/delete")
    public Call<Void> deleteNote(@Body DeleteNoteRequest body);

    @GET("api/notes/get")
    public Call<ArrayList<Note>> getNotes(@Body GetSomeRequest body);
}

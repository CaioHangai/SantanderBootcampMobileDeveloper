package me.dio.matchsimulator.data;

import java.util.List;

import me.dio.matchsimulator.domain.Match;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesAPI {

    @GET("matchesAPI.json")
    Call<List<Match>> getMatches();
}

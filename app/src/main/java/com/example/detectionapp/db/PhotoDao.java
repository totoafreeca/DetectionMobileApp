package com.example.detectionapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Photo photo);

    @Update
    public void update(Photo photo);

    @Delete
    public void delete(Photo photo);


    @Query("DELETE FROM photo")
    public void deleteAll();

    @Query("DELETE FROM photo WHERE uid = (:Id)")
    void deletePhotoById (int Id);

    @Query("SELECT * FROM photo ORDER BY filename")
    public LiveData<List<Photo>> findAll();


    @Query("SELECT * FROM photo ORDER BY filename")
    public List<Photo> getAllAsc();

    @Query("SELECT * FROM photo ORDER BY filename DESC")
    public List<Photo> getAllDesc();



}
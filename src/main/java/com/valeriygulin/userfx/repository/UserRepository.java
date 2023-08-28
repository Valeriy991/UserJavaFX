package com.valeriygulin.userfx.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valeriygulin.userfx.model.User;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private ArrayList<User> userList = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public UserRepository() {
    }

    public UserRepository(String urlSite) throws IOException {
        URL url = new URL(urlSite);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream())) {
            this.userList = objectMapper.readValue(bufferedInputStream, new TypeReference<>() {
            });
        }
    }

    public UserRepository(File file) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            this.userList = objectMapper.readValue(bufferedReader, new TypeReference<>() {
            });
        }
    }

    public void save(File file) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            objectMapper.writeValue(bufferedWriter, this.userList);
        }
    }

    public void delete(User user) {
        this.userList.remove(user);
    }

    public void add(User user) {
        this.userList.add(user);
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "userList=" + userList;
    }
}

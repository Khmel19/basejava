package com.khmel.wedapp.storage;

import com.khmel.wedapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage implements Storage{
    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Resume " + resume.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void update(Resume resume) {
        if (getIndex(resume.getUuid()) == -1) {
            System.out.println("Resume " + resume.getUuid() + " not exist");
        } else {
            storage[getIndex(resume.getUuid())] = resume;
        }
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[getIndex(uuid)];
    }

    public void delete(String uuid) {
        if (getIndex(uuid) == -1) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            storage[getIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
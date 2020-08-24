package com.khmel.webapp.storage;

import com.khmel.webapp.exсeption.StorageException;
import com.khmel.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public class AbstractArrayStorageTest extends AbstractStorageTest {
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }
    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name "+i));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("Overflow"));
    }
}

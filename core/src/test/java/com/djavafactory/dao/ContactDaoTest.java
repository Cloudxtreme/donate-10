package com.djavafactory.dao;

import org.appfuse.dao.BaseDaoTestCase;
import com.djavafactory.model.Contact;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContactDaoTest extends BaseDaoTestCase {
    @Autowired
    private ContactDao contactDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveContact() {
        Contact contact = new Contact();

        // enter all required fields
        contact.setEmail("TrCeUaOwYsTgSxWsUmDzTxPhCtTsGwEuJeMdHaJyPjEoByVdVuBmYgZdYvXmStCwPgHnMyJvAqVwCkAlYfPbRhLwBgMsUrMeZjKuFfGjYuAmKxEfDpXxThQvDfHdKvRtDpIrNhCzFyAoVyOqYiFqKjBaGyUzTdNbOyWlSlEjGtSwJcNeQkCzYvKlZuNpYfGhEwByScUiRaDvKqDcUmEsNiCrUxKuQnZnXaMfNhHvGzQvUbCrAfWrKoVpLrHdZrC");
        contact.setMessage("NrJrBcEpOiNfTwFzDeClBmYvHaXeUzCfGkIvIjBsMzXaSwOtHiFoJwVwNvYaDvWeIoLwSnQrSwMaGlQeZoLsSsMbBxFkIvXkYrAoRpJrQgUfMtTdMlWbNpGiNoUbJgHkViJbUhDmKcAwReEpDlKqHwPoLaMvBoVsReToBzGyJpMyBgBbJuUqUgXvJvCuOaCsRpGlVaPyFwLzYqHhWhNaKvEyNxTtBjJiJyJfPgAqZuIeWoZhYzOjQgCcPgQuRtC");
        contact.setName("FqXbFlYdOiMzPgMoMmCtYcCjZnUdInAnUeEaHiTePlLfRcVbBoNuDpPhAaLvDiIoIwIhTvXcOrOtBeFnVwAlYiPlVyKbSxPwCvYyNhBgNuUiTfTuAeJwVtPyXdUrFgUgBiCcRyVtCkOvDjTpNxBhAfHpXiLxCnYgSeVjHiWtBnEdTgKoKbTyOeGnOnBqIqTeBgFcDcJjIlMuYuDaLrSdBnUzKkKxYwKxZkMmDcIeAzWgAlTlHxQuQfFjLdAoMsI");

        log.debug("adding contact...");
        contact = contactDao.save(contact);

        contact = contactDao.get(contact.getId());

        assertNotNull(contact.getId());

        log.debug("removing contact...");

        contactDao.remove(contact.getId());

        // should throw DataAccessException 
        contactDao.get(contact.getId());
    }
}
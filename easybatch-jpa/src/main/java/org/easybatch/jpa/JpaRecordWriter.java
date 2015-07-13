/*
 *  The MIT License
 *
 *   Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */

package org.easybatch.jpa;

import org.easybatch.core.api.RecordProcessingException;
import org.easybatch.core.writer.AbstractRecordWriter;

import javax.persistence.EntityManager;

/**
 * Write entities to a database using JPA.
 * <p/>
 * This writer does not commit a transaction after writing records.
 * You can use a {@link JpaTransactionStepListener} for this purpose.
 *
 * @param <T> the entity type.
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class JpaRecordWriter<T> extends AbstractRecordWriter<T> {

    private EntityManager entityManager;

    /**
     * Create a JPA record writer.
     *
     * @param entityManager the entity manager to write records.
     */
    public JpaRecordWriter(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void writeRecord(final T record) throws RecordProcessingException {
        entityManager.persist(record);
    }
}

package com.jkubica.persistence;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.jkubica.persistence.datasource.dao.DaoStoreroom;
import com.jkubica.persistence.datasource.database.StoreroomDatabase;
import com.jkubica.persistence.datasource.entities.EntityCategory;
import com.jkubica.persistence.datasource.entities.EntityItem;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Date;

import static com.jkubica.persistence.CommonUtils.removeMiliseconds;

/**
 * Created by jkubica on 13.01.2018.
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    // =============================================================================================
    // Attributes
    // =============================================================================================

    private DaoStoreroom daoStoreroom;
    private StoreroomDatabase storeroomDatabase;

    // =============================================================================================
    // Test entities
    // =============================================================================================

    private static EntityCategory entityCategory = new EntityCategory();
    static {
        entityCategory.setId(1);
        entityCategory.setName("Category");
        entityCategory.setNote("The test category");
    }

    private static EntityItem entityItem = new EntityItem();
    static {
        entityItem.setId(1);
        entityItem.setAddedDate(new Date());
        entityItem.setCategoryId(entityCategory.getId());
        entityItem.setNote("The test category");
    }

    // =============================================================================================
    // Methods
    // =============================================================================================

    /**
     * Execute before the tests start
     */
    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        storeroomDatabase = StoreroomDatabase.createDatabase(context);
    }

    /**
     * Execute after the test stop
     *
     * @throws IOException
     */
    @After
    public void closeDb() throws IOException {
        StoreroomDatabase.clear();
    }

    /**
     * Test insertion of category records
     */
    @Test
    public void testInsertAndSelectCategory() {
        // for purpose of single test execution
        if(storeroomDatabase==null || !storeroomDatabase.isOpen()){
            createDb();
        }
        // perform insertion of category
        storeroomDatabase.daoStoreroom().insertCategory(entityCategory);
        // assert result of testing operation
        EntityCategory storedCategory = storeroomDatabase.daoStoreroom().getCategoryById(entityCategory.getId());
        Assert.assertNotNull(storedCategory);
        Assert.assertEquals(entityCategory.getId(),storedCategory.getId());
        Assert.assertEquals(entityCategory.getName(),storedCategory.getName());
        Assert.assertEquals(entityCategory.getNote(),storedCategory.getNote());
    }

    @Test
    public void testInsertAndSelectItem() {
        // at first insert category
        testInsertAndSelectCategory();
        // then insert item
        storeroomDatabase.daoStoreroom().insertItem(entityItem);
        // assert result of testing operation
        EntityItem storedItem = storeroomDatabase.daoStoreroom().getItemById(entityItem.getId());
        Assert.assertNotNull(storedItem);
        Assert.assertEquals(storedItem.getCategoryId(),entityItem.getCategoryId());
        Assert.assertEquals(storedItem.getId(),entityItem.getId());
        Assert.assertEquals(storedItem.getNote(),entityItem.getNote());
        Assert.assertEquals(removeMiliseconds(storedItem.getAddedDate()).getTime(),removeMiliseconds(entityItem.getAddedDate()).getTime());
    }



}

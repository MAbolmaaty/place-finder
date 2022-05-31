package com.emupapps.placefinder.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.emupapps.placefinder.db.BookmarkDao
import com.emupapps.placefinder.db.PlaceFinderDatabase
import com.emupapps.placefinder.model.Bookmark

class BookmarkRepo(context: Context) {

    private val db = PlaceFinderDatabase.getInstance(context)
    private val bookmarkDao: BookmarkDao = db.bookmarkDao()

    fun addBookmark(bookmark: Bookmark): Long? {
        val newId = bookmarkDao.insertBookmark(bookmark)
        bookmark.id = newId
        return newId
    }

    fun createBookmark(): Bookmark {
        return Bookmark()
    }

    val allBookmarks: LiveData<List<Bookmark>>
        get() {
            return bookmarkDao.loadAll()
        }
}
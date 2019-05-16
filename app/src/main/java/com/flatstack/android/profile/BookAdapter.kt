package com.flatstack.android.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.flatstack.android.R
import com.flatstack.android.profile.BookAdapter.BookViewHolder
import com.flatstack.android.profile.entities.Book
import kotlinx.android.synthetic.main.book_item.view.*

class BookAdapter(private val bookList: List<Book>) : RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int = bookList.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.title.text = book.title
        holder.count.text = book.numberOfTimesRead.toString()
    }

    class BookViewHolder(view: View) : ViewHolder(view) {
        val title: TextView = view.tv_title
        val count: TextView = view.tv_count
    }
}

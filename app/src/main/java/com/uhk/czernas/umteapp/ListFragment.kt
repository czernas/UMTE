package com.uhk.czernas.umteapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.uhk.czernas.umteapp.model.User
import com.uhk.czernas.umteapp.model.UserDB
import com.uhk.czernas.umteapp.model.UserDao
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.row_user.*

class ListFragment : Fragment() {

    val list = mutableListOf<User>()
    val dbList = mutableListOf<UserDB>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbList.addAll(UserDao().selectAll())

        val adapter = Adapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        addButton.setOnClickListener {
            val user = User(editText.text.toString(), "", 0, 0)
            list.add(user)

            val userDb = UserDB()
            userDb.name = editText.text.toString()
            dbList.add(userDb)
            UserDao().createOrUpdate(userDb)

            editText.setText("")
            adapter.notifyDataSetChanged()
        }
    }

    inner class Adapter : RecyclerView.Adapter<Adapter.Holder>() {

        override fun onCreateViewHolder(root: ViewGroup, p1: Int): Holder {
            return Holder(
                    LayoutInflater.from(context)
                            .inflate(R.layout.row_user, root, false)
            )
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.onBind()
        }

        override fun getItemCount(): Int {
            return dbList.size
        }

        inner class Holder(val item: View) : RecyclerView.ViewHolder(item),
                View.OnClickListener,
                View.OnLongClickListener {

            init {
                item.setOnClickListener(this)
                item.setOnLongClickListener(this)
            }

            fun onBind() {
                val textView = item.findViewById<TextView>(R.id.nameTextView)
                val user = dbList[layoutPosition]

                textView.text = user.name
            }

            override fun onClick(v: View?) {
                // otevřít detail uživatele todo
            }

            override fun onLongClick(v: View?): Boolean {
                val user = dbList[layoutPosition]
                UserDao().delete(user)
                dbList.removeAt(layoutPosition)
                notifyItemRemoved(layoutPosition)
                return true
            }
        }
    }
}
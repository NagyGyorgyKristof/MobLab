package com.example.moblabandroid.ui.mainlist

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.moblabandroid.R
import com.example.moblabandroid.injector
import com.example.moblabandroid.model.Result
import com.example.moblabandroid.ui.details.ItemDetailActivity
import com.example.moblabandroid.ui.mainlist.CharacterAdapter.Listener
import hu.bme.aut.android.kotifydemo.ui.utils.hide
import hu.bme.aut.android.kotifydemo.ui.utils.show
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*
import javax.inject.Inject


class CharacterListActivity : AppCompatActivity(), MainListScreen, Listener {


    private lateinit var listAdapter: CharacterAdapter

    @Inject
    lateinit var presenter: MainListPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        injector.inject(this)


        setSupportActionBar(toolbar)
        toolbar.title = title

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        setupRecyclerView()
        setUpRefreshView()
    }

    override fun onResume() {
        super.onResume()
        injector.inject(this)
        presenter.attachScreen(this)
        presenter.refreshArtists()
    }

    override fun onPause() {
        super.onPause()
        presenter.detachScreen()
    }

    private fun setupRecyclerView() {
        listAdapter = CharacterAdapter(this)
        characterList?.adapter = listAdapter
    }

    private fun setUpRefreshView() {
        swipeRefreshLayoutArtists?.setOnRefreshListener {
            presenter.refreshArtists()
        }
    }

    override fun showCharacters(characters: List<Result>) {
        swipeRefreshLayoutArtists?.isRefreshing = false

        if (characters.isEmpty()) {
            characterList?.hide()
            tvEmpty?.show()
        } else {
            characterList?.show()
            tvEmpty?.hide()
            listAdapter.submitList(characters)

        }
    }

    override fun showNetworkError(message: String) {
        swipeRefreshLayoutArtists?.isRefreshing = false
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onCharacterClicked(character: Result) {

        startActivity(Intent(this, ItemDetailActivity::class.java))
    }
}

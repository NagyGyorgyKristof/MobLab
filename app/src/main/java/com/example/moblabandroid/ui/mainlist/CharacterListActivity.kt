package com.example.moblabandroid.ui.mainlist

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.moblabandroid.R
import com.example.moblabandroid.injector
import com.example.moblabandroid.model.CharacterX
import com.example.moblabandroid.ui.details.CharacterDetailActivity
import com.example.moblabandroid.ui.details.CharacterDetailActivity.Companion.KEY_CHARACTER_ID
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
        supportActionBar?.title = getString(R.string.characters)

        setupRecyclerView()
        setUpRefreshView()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachScreen(this)
        presenter.load()
    }

    override fun onPause() {
        super.onPause()
        presenter.detachScreen()
    }

    private fun setupRecyclerView() {
        listAdapter = CharacterAdapter(this)
        listAdapter.listener = this
        characterList?.adapter = listAdapter
    }

    private fun setUpRefreshView() {
        swipeRefreshLayoutArtists?.setOnRefreshListener {
            presenter.load()
        }
    }

    override fun showCharacters(characters: List<CharacterX>?) {
        swipeRefreshLayoutArtists?.isRefreshing = false

        if (characters?.isEmpty() == true) {
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

    override fun onCharacterClicked(character: CharacterX) {
        val intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra(KEY_CHARACTER_ID, character.id)
        startActivity(intent)
    }
}

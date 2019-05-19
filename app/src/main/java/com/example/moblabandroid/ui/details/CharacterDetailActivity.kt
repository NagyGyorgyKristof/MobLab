package com.example.moblabandroid.ui.details

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.moblabandroid.R
import com.example.moblabandroid.injector
import com.example.moblabandroid.model.CharacterX
import com.example.moblabandroid.ui.mainlist.CharacterListActivity
import hu.bme.aut.android.kotifydemo.ui.utils.hide
import hu.bme.aut.android.kotifydemo.ui.utils.show
import kotlinx.android.synthetic.main.activity_item_detail.*
import javax.inject.Inject

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [CharacterListActivity].
 */
class CharacterDetailActivity : AppCompatActivity(), DetailsScreen {


    companion object {
        const val KEY_CHARACTER_ID = "CHARACTER_ID"
    }

    private var characterID: Long = 0

    @Inject
    lateinit var presenter: DetailsPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        injector.inject(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        initArguments()
    }

    private fun initArguments() {
        characterID = intent?.extras?.getInt(KEY_CHARACTER_ID)?.toLong() ?: 0
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                navigateUpTo(Intent(this, CharacterListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    override fun onResume() {
        super.onResume()
        presenter.attachScreen(this)
        presenter.load(characterID)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachScreen()
    }

    override fun showNetworkError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showCharacter(character: CharacterX?) {
        if (character != null) {
            Glide.with(this).load(character.image).into(characterImage)
            name.text = character.name
            statusText.text = character.status
            speciesText.text = character.species
            if (character.type.isBlank()) {
                typeText.hide()
                typeLabelText.hide()
            } else {
                typeText.show()
                typeLabelText.show()
                typeText.text = character.type
            }
            genderText.text = character.gender
            originText.text = character.origin?.name
            locationText.text = character.origin?.name
        }
    }
}

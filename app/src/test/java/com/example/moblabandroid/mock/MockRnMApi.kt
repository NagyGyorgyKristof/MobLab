package hu.bme.aut.android.kotifydemo.mock

import com.example.moblabandroid.model.*
import com.example.moblabandroid.network.RnMApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockRnMApi : RnMApi {
    override fun getAllChars(): Call<BaseCharacterWithPagesX> {
        val originX = OriginX("Earth", "")
        val locationX = LocationX("Earth", "")
        val infoX = InfoX(10, "", 5, "")
        val character = CharacterX(episode = emptyList())
        character.apply {
            image = "image"
            created = "now"
            gender = "male"
            status = "live"
            origin = originX
            location = locationX
            species = "human"
            type = "unknown"
        }
        val characterWithPagesX = BaseCharacterWithPagesX(infoX, mutableListOf(character))

        val call = object : Call<BaseCharacterWithPagesX> {
            @Throws(IOException::class)
            override fun execute(): Response<BaseCharacterWithPagesX> {
                return Response.success(characterWithPagesX)
            }

            override fun enqueue(callback: Callback<BaseCharacterWithPagesX>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<BaseCharacterWithPagesX> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }
        return call
    }

    override fun createNewChar(body: CharacterX?): Call<Void> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCharacterById(characterId: Long?): Call<CharacterX> {
        val originX = OriginX("Earth", "")
        val locationX = LocationX("Earth", "")

        val character = CharacterX(episode = emptyList())
        character.apply {
            image = "image"
            created = "now"
            gender = "male"
            status = "live"
            origin = originX
            location = locationX
            species = "human"
            type = "unknown"
        }


        val call = object : Call<CharacterX> {
            @Throws(IOException::class)
            override fun execute(): Response<CharacterX> {
                return Response.success(character)
            }

            override fun enqueue(callback: Callback<CharacterX>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<CharacterX> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }
        return call
    }

    override fun updateChar(characterId: Long?, body: CharacterX?): Call<Void> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deletChar(characterId: Long?): Call<Void> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

package hu.autsoft.cardiolifestyle.data.db

import android.arch.persistence.room.Room
import android.content.Context
import com.example.moblabandroid.db.RnMDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    companion object {
        private const val DB_NAME = "rnm-db"
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): RnMDataBase {
        return Room.databaseBuilder(
            context,
            RnMDataBase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterDao(rnMDataBase: RnMDataBase) = rnMDataBase.characterDao()
}

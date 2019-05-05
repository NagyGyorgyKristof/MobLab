package com.example.moblabandroid.ui.details

import com.example.moblabandroid.interactor.ApiInteractor
import com.example.moblabandroid.interactor.event.GetCharacterEvent
import com.example.moblabandroid.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val executor: Executor,
    private val ApiInteractor: ApiInteractor
) : Presenter<DetailsScreen>() {

    override fun attachScreen(screen: DetailsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun load(characterId: Long) {
        executor.execute {
            ApiInteractor.getCharacterById(characterId)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetCharacterEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.characters != null) {
                    screen?.showCharacter(event.characters?.firstOrNull())
                }
            }
        }
    }
}
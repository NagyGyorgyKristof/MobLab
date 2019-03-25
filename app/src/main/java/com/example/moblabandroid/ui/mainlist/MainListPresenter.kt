package com.example.moblabandroid.ui.mainlist

import com.example.moblabandroid.interactor.ApiInteractor
import com.example.moblabandroid.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class MainListPresenter @Inject constructor(private val executor: Executor, private val ApiInteractor: ApiInteractor) : Presenter<MainListScreeen>() {

}
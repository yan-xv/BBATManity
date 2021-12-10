package com.rsschool.finaltask.yanxv.bbatmanity.ui.map

import androidx.lifecycle.ViewModel
import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankRequestParam
import com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.api.GetBelarusbankAtmUseCase
import com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.api.GetBelarusbankCustomUseCase
import com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.api.GetBelarusbankFilialUseCase
import com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.api.GetBelarusbankInfoboxUseCase
import com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.settings.GetSettingsMapCityUseCase
import com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.settings.GetSettingsMapUseCase
import com.rsschool.finaltask.yanxv.bbatmanity.ui.model.MarkerMap
import com.rsschool.finaltask.yanxv.bbatmanity.ui.utils.ReferenceCityPosition
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ActivityScope
class MapViewModel @Inject constructor(
    private val getBelarusbankAtmUseCase: GetBelarusbankAtmUseCase,
    private val getBelarusbankInfoboxUseCase: GetBelarusbankInfoboxUseCase,
    private val getBelarusbankFilialUseCase: GetBelarusbankFilialUseCase,
    private val getBelarusbankCustomUseCase: GetBelarusbankCustomUseCase,
    private val getSettingsMapUseCase: GetSettingsMapUseCase,
    private val getSettingsMapCityUseCase: GetSettingsMapCityUseCase
) : ViewModel() {

    private var city = getSettingsMapCityUseCase.execute()
    var targetLat = ReferenceCityPosition.getLatByCity(city = city)
    var targetLng = ReferenceCityPosition.getLngByCity(city = city)


    fun fetchBelarusbankAnyNearestUseCase(
        countObject: Int
    ): Flow<List<MarkerMap>> {

        city = getSettingsMapCityUseCase.execute()
        targetLat = ReferenceCityPosition.getLatByCity(city = city)
        targetLng = ReferenceCityPosition.getLngByCity(city = city)

        val belarusbankRequestParam = BelarusbankRequestParam(
            city = city,
            targetLat = targetLat,
            targetLng = targetLng,
            countObject = countObject
        )
        return getBelarusbankCustomUseCase.execute(belarusbankRequestParam).map { list ->
            list.map { MarkerMap(it) }
        }
    }

/*
    fun fetchBelarusbankATM() =
        getBelarusbankAtmUseCase.execute(BELARUSBANK_REQUEST_PARAM)
            //.mapToSingleMapMarker()
            //.subscribeListMapMarker()

    fun fetchBelarusbankInfobox(): Flow<List<MarkerMap>> =
         getBelarusbankInfoboxUseCase.execute(BELARUSBANK_REQUEST_PARAM)
            //.mapToSingleMapMarker()
            //.subscribeListMapMarker()

    fun fetchBelarusbankFilial() =
         getBelarusbankFilialUseCase.execute(BELARUSBANK_REQUEST_PARAM)
            //.mapToSingleMapMarker()
            //.subscribeListMapMarker()
            */

    /*
        private fun List<MarkerMap>.subscribeListMapMarker() {
            onEach {
                _listMapMarker.value = it

            }
                .catch {

                    Log.e("ERROR", "Can't log in", it)
                }
                .launchIn(lifecycle.coroutineScope)
            /*
            disposable = subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { _listMapMarker.value = it },
                    { _errorMessage.value = it.message }
                )

             */
        }
    /*
        private fun Flow<List<BelarusbankObject>>.mapToSingleMapMarker() : Flow<List<MarkerMap>> {
            //map { list -> list.map { MarkerMap(it) } }
            return this.onEach {
                _listMapMarker.value = it

            }
                .catch {

                    Log.e("ERROR", "Can't log in", it)
                }
        }
    */
    */
}
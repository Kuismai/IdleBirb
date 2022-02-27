package fi.oamk.idlebirb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var _seeds = MutableLiveData<Int>(0)
    var seeds: LiveData<Int> = _seeds

    private var _feathers = MutableLiveData<Int>(0)
    var feathers: LiveData<Int> = _feathers

    private var _multiplier = MutableLiveData<Int>(1)
    var multiplier: LiveData<Int> = _multiplier

    private var _babies = MutableLiveData<Int>(0)
    var babies: LiveData<Int> = _babies

    private var _nests = MutableLiveData<Int>(0)
    var nests: LiveData<Int> = _nests

    private var _mommas = MutableLiveData<Int>(0)
    var mommas: LiveData<Int> = _mommas

    private var _babyPrice = MutableLiveData<Double>(50.0)
    var babyPrice: LiveData<Double> = _babyPrice

    var beakPrice = 20
    var birboPrice = 3000
    var stripePrice = 10000

    var nestPrice = 20
    var mommaPrice1 = 100
    var mommaPrice2 = 2000

    fun setSeeds(i: Int) {
        _seeds.value = i
    }

    fun setFeathers(i: Int) {
        _feathers.value = i
    }

    fun setMulti(i: Int){
        _multiplier.value = i
    }

    fun setBaby(i: Int){
        _babies.value = i
    }

    fun setNest(i: Int){
        _nests.value = i
    }

    fun setMomma(i: Int){
        _mommas.value = i
    }

    fun setBabyPrice(i: Int){
        _babyPrice.value = i.toDouble()
    }
}
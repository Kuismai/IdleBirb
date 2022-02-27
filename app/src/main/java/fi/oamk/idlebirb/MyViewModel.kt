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

    private var _nestPrice = MutableLiveData<Double>(20.0)
    var nestPrice: LiveData<Double> = _nestPrice

    private var _mommaPrice1 = MutableLiveData<Double>(100.0)
    var mommaPrice1: LiveData<Double> = _mommaPrice1

    private var _mommaPrice2 = MutableLiveData<Double>(2000.0)
    var mommaPrice2: LiveData<Double> = _mommaPrice2


    var beakPrice = 20
    var birboPrice = 3000
    var stripePrice = 10000

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

    fun setNestPrice(i: Int){
        _nestPrice.value = i.toDouble()
    }

    fun setMommaPrice1(i: Int){
        _mommaPrice1.value = i.toDouble()
    }

    fun setMommaPrice2(i: Int){
        _mommaPrice2.value = i.toDouble()
    }
}
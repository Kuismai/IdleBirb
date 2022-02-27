package fi.oamk.idlebirb


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Flock.newInstance] factory method to
 * create an instance of this fragment.
 */
class Flock : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val viewModel: MyViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flock, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonBaby = view.findViewById<Button>(R.id.babyBuyButton)
        var babyPrice = viewModel.babyPrice.value!!

        buttonBaby.text = babyPrice.toInt().toString() + " seeds"
        buttonBaby.setOnClickListener {
            buyBaby()
        }

        val buttonNest = view.findViewById<Button>(R.id.nestBuyButton)
        var nestPrice = viewModel.nestPrice.value!!

        buttonNest.text = nestPrice.toInt().toString() + " feathers"
        buttonNest.setOnClickListener {
            buyNest()
        }

        val buttonMomma = view.findViewById<Button>(R.id.mommaBuyButton)
        var mommaPrice1 = viewModel.mommaPrice1.value!!
        var mommaPrice2 = viewModel.mommaPrice2.value!!

        buttonMomma.text = mommaPrice1.toInt().toString() + " F," + mommaPrice2.toInt().toString() + " S"
        buttonMomma.setOnClickListener {
            buyMomma()
        }

    }

    private fun buyMomma() {
        var featherCount = viewModel.feathers.value!!
        var seedCount = viewModel.seeds.value!!
        var mommaPrice1 = viewModel.mommaPrice1.value!!
        var mommaPrice2 = viewModel.mommaPrice2.value!!
        var mommaCount = viewModel.mommas.value!!

        if (featherCount >= mommaPrice1.toInt()) {

            if (seedCount >= mommaPrice2.toInt()) {
                var featherCount1 = featherCount - mommaPrice1.toInt()
                viewModel.setFeathers(featherCount1)
                var seedCount1 = seedCount - mommaPrice2.toInt()
                viewModel.setSeeds(seedCount1)

                var mommaCount1 = mommaCount + 1
                viewModel.setMomma(mommaCount1)

                var mommaPrice11 = mommaPrice1 * 1.5
                viewModel.setMommaPrice1(mommaPrice11.toInt())
                var mommaPrice21 = mommaPrice2 * 1.75
                viewModel.setMommaPrice2(mommaPrice21.toInt())

                val buttonMomma = view?.findViewById<Button>(R.id.mommaBuyButton)

                buttonMomma?.text = mommaPrice11.toInt().toString() + " F," + mommaPrice21.toInt().toString() + " S"
            }
        }
    }

    private fun buyNest() {
        var featherCount = viewModel.feathers.value!!
        var nestPrice = viewModel.nestPrice.value!!
        var nestCount = viewModel.nests.value!!

        if (featherCount >= nestPrice.toInt()) {
            var featherCount1 = featherCount - nestPrice.toInt()
            viewModel.setFeathers(featherCount1)
            var nestCount1 = nestCount + 1
            viewModel.setNest(nestCount1)

            var nestPrice1 = nestPrice * 1.5
            viewModel.setNestPrice(nestPrice1.toInt())

            val buttonNest = view?.findViewById<Button>(R.id.nestBuyButton)

            buttonNest?.text = nestPrice1.toInt().toString() + " feathers"
        }
    }

    private fun buyBaby() {
        var seedCount = viewModel.seeds.value!!
        var babyPrice = viewModel.babyPrice.value!!
        var babyCount = viewModel.babies.value!!

        if (seedCount >= babyPrice.toInt()) {
            var seedCount1 = seedCount - babyPrice.toInt()
            viewModel.setSeeds(seedCount1)
            var babyCount1 = babyCount + 1
            viewModel.setBaby(babyCount1)

            var babyPrice1 = babyPrice * 1.1
            viewModel.setBabyPrice(babyPrice1.toInt())

            val buttonBaby = view?.findViewById<Button>(R.id.babyBuyButton)

            buttonBaby?.text = babyPrice1.toInt().toString() + " seeds"
            }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Flock.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Flock().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}
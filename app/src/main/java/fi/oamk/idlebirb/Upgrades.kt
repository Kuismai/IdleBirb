package fi.oamk.idlebirb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Upgrades.newInstance] factory method to
 * create an instance of this fragment.
 */
class Upgrades : Fragment() {
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
        return inflater.inflate(R.layout.fragment_upgrades, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonBeak = view.findViewById<Button>(R.id.beakBuyButton)
        var beakPrice = viewModel.beakPrice

        buttonBeak.text = beakPrice.toString() + " seeds"
        buttonBeak.setOnClickListener {
            buyBeak()
        }

        val buttonBirbo = view.findViewById<Button>(R.id.birbocularsBuyButton)
        var birboPrice = viewModel.birboPrice

        buttonBirbo.text = birboPrice.toString() + " seeds"
        buttonBirbo.setOnClickListener {
            buyBirbo()
        }

        val buttonStripes = view.findViewById<Button>(R.id.stripeBuyButton)
        var stripePrice = viewModel.stripePrice

        buttonStripes.text = stripePrice.toString() + " seeds"
        buttonStripes.setOnClickListener {
            buyStripes()
        }
    }

    private fun buyBeak() {
        var seedCount = viewModel.seeds.value!!
        var beakPrice = viewModel.beakPrice
        var multiplier = viewModel.multiplier.value!!


        if (seedCount >= beakPrice) {
            //Toast.makeText(context, "enough!", Toast.LENGTH_SHORT).show()
            var seedCount1 = seedCount - beakPrice
            viewModel.setSeeds(seedCount1)
            var multiplier1 = multiplier * 3
            viewModel.setMulti(multiplier1)

            val buttonBeak = view?.findViewById<Button>(R.id.beakBuyButton)
            buttonBeak!!.isEnabled = false
            buttonBeak!!.text = getString(R.string.beakbought)
        }
    }


    private fun buyBirbo() {
        var seedCount = viewModel.seeds.value!!
        var birboPrice = viewModel.birboPrice
        var multiplier = viewModel.multiplier.value!!

        if (seedCount > birboPrice) {
            var seedCount1 = seedCount - birboPrice
            viewModel.setSeeds(seedCount1)
            var multiplier1 = multiplier * 5
            viewModel.setMulti((multiplier1))
            val buttonBirbo = view?.findViewById<Button>(R.id.birbocularsBuyButton)
            buttonBirbo!!.isEnabled = false
            buttonBirbo!!.text = getString(R.string.birbobought)
        }
    }

    private fun buyStripes() {
        var seedCount = viewModel.seeds.value!!
        var stripePrice = viewModel.stripePrice
        var multiplier = viewModel.multiplier.value!!

        if (seedCount > stripePrice) {
            var seedCount1 = seedCount - stripePrice
            viewModel.setSeeds(seedCount1)
            var multiplier1 = multiplier * 10
            viewModel.setMulti(multiplier1)

            val buttonStripes = view?.findViewById<Button>(R.id.stripeBuyButton)
            buttonStripes!!.isEnabled = false
            buttonStripes!!.text = getString(R.string.stripebought)
        }
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Upgrades.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Upgrades().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
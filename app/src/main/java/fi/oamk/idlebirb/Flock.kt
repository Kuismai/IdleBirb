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
        var nestPrice = viewModel.nestPrice

        buttonNest.text = nestPrice.toString() + " feathers"
        buttonNest.setOnClickListener {
            buyNest()
        }

        val buttonMomma = view.findViewById<Button>(R.id.mommaBuyButton)
        var mommaPrice1 = viewModel.mommaPrice1
        var mommaPrice2 = viewModel.mommaPrice2

        buttonMomma.text = mommaPrice1.toString() + " feathers," + mommaPrice2.toString() + " seeds"
        buttonMomma.setOnClickListener {
            buyMomma()
        }

    }

    private fun buyMomma() {
        TODO("Not yet implemented")
    }

    private fun buyNest() {
        TODO("Not yet implemented")
    }

    private fun buyBaby() {
        var seedCount = viewModel.seeds.value!!
        var babyPrice = viewModel.babyPrice.value!!
        var babyCount = viewModel.babies.value!!

        if (seedCount >= babyPrice.toInt()) {
            var seedCount1 = seedCount - babyPrice.toInt()
            viewModel.setSeeds(seedCount1)
            var babyCount1 = babyCount + 1
            viewModel.setMulti(babyCount1)

            var babyPrice1 = babyPrice * 1.1
            viewModel.setBabyPrice(babyPrice1.toInt())
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
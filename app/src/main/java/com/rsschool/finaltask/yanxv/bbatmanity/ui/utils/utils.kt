import android.content.Context
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.rsschool.finaltask.yanxv.bbatmanity.R
import com.rsschool.finaltask.yanxv.bbatmanity.ui.utils.BitmapHelper

fun getIcon(context: Context, isOpen: Boolean): BitmapDescriptor {
    val color = getColorIcon(context, isOpen)
    return BitmapHelper.vectorToBitmap(context, R.drawable.ic_belarusbank_atm_map_24dp, color)
}

private fun getColorIcon(context: Context, isOpen: Boolean): Int {
    return ContextCompat.getColor(context, if (isOpen) R.color.belarusbank_green else R.color.belarusbank_gray)
}
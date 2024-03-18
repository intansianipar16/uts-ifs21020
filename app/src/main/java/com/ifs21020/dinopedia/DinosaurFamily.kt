import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DinosaurFamily(
    val name: String,
    val description: String,
    val lifespan: String,
    val physicalCharacteristics: String,
    val habitat: String,
    val behavior: String,
    val classification: String,
    val imageResourceId: Int
) : Parcelable

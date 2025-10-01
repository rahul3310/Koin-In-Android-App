import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun ImageLoader(
    imageUrl: String,
    placeholderRes: Int,
    errorRes: Int? = null,
    contentScale: ContentScale = ContentScale.Crop,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build(),
        placeholder = painterResource(id = placeholderRes),
        error = errorRes?.let { painterResource(id = it) },
        contentDescription = "image",
        contentScale = contentScale,
        onLoading = { Log.d("Coil3", "Image loading: $imageUrl") },
        onSuccess = { Log.d("Coil3", "Image loaded successfully: $imageUrl") },
        onError = { Log.e("Coil3", "Image load failed: $imageUrl") },
        modifier = modifier
            .padding(16.dp)
            .border(4.dp, color = Color.DarkGray, RoundedCornerShape(4.dp))
            .padding(8.dp)
    )
}

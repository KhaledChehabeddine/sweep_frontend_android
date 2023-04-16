package com.example.sweep.utilities.functions

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest

@Composable
fun svgS3UrlToPainter(url: String): Painter {
  return rememberAsyncImagePainter(
    model = ImageRequest.Builder(context = LocalContext.current)
      .decoderFactory(factory = SvgDecoder.Factory())
      .data(data = url)
      .build()
  )
}

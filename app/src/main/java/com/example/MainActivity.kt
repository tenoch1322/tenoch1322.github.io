package com.example

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.OpenInBrowser
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ui.theme.DarkBg
import com.example.ui.theme.DarkBorder
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.GoogleBlue
import com.example.ui.theme.GoogleGreen
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        DeveloperPortalScreen()
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun DeveloperPortalScreen() {
  val context = LocalContext.current
  var webViewInstance by remember { mutableStateOf<WebView?>(null) }
  var canGoBack by remember { mutableStateOf(false) }
  var isLoading by remember { mutableStateOf(true) }
  var showUrlsDialog by remember { mutableStateOf(false) }

  // Handle system back gesture
  BackHandler(enabled = canGoBack) {
    webViewInstance?.goBack()
  }

  Scaffold(
    topBar = {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(DarkSurface)
      ) {
        TopAppBar(
          title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Box(
                modifier = Modifier
                  .size(32.dp)
                  .background(GoogleBlue, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
              ) {
                Text(
                  text = "TG",
                  color = Color.White,
                  fontSize = 14.sp,
                  fontWeight = FontWeight.Bold
                )
              }
              Spacer(modifier = Modifier.width(8.dp))
              Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text(
                    text = "Tenoch Girón | Studio",
                    style = MaterialTheme.typography.titleMedium.copy(
                      fontWeight = FontWeight.Bold,
                      fontSize = 15.sp,
                      color = Color.White
                    )
                  )
                  Spacer(modifier = Modifier.width(4.dp))
                  Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Verificado",
                    tint = GoogleGreen,
                    modifier = Modifier.size(14.dp)
                  )
                }
                Text(
                  text = "Google Play Verified Developer Portal",
                  style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 10.sp,
                    color = Color(0xFF94A3B8)
                  )
                )
              }
            }
          },
          actions = {
            IconButton(
              onClick = { showUrlsDialog = true },
              modifier = Modifier.testTag("btn_play_urls")
            ) {
              Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "URLs de Google Play Console",
                tint = GoogleBlue
              )
            }
            IconButton(
              onClick = { webViewInstance?.reload() },
              modifier = Modifier.testTag("btn_reload")
            ) {
              Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Recargar portal",
                tint = Color.White
              )
            }
          },
          colors = TopAppBarDefaults.topAppBarColors(
            containerColor = DarkSurface
          )
        )

        // Quick Navigation Filter Chips Row
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 12.dp, vertical = 6.dp),
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          QuickNavChip("Ecosistema Apps") {
            webViewInstance?.loadUrl("file:///android_asset/web/index.html#apps")
          }
          QuickNavChip("Demo ChefMágico") {
            webViewInstance?.loadUrl("javascript:launchSandbox('chef')")
          }
          QuickNavChip("Demo Emociona") {
            webViewInstance?.loadUrl("javascript:launchSandbox('emociona')")
          }
          QuickNavChip("Demo CETis 23") {
            webViewInstance?.loadUrl("javascript:launchSandbox('cetis')")
          }
          QuickNavChip("Proyectos IA") {
            webViewInstance?.loadUrl("file:///android_asset/web/index.html#portfolio")
          }
          QuickNavChip("Eliminar Datos (Play)") {
            webViewInstance?.loadUrl("file:///android_asset/web/index.html#data-deletion")
          }
          QuickNavChip("app-ads.txt") {
            webViewInstance?.loadUrl("file:///android_asset/web/index.html#app-ads")
          }
        }
      }
    },
    containerColor = DarkBg
  ) { paddingValues ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      AndroidView(
        factory = { ctx ->
          WebView(ctx).apply {
            layoutParams = ViewGroup.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT,
              ViewGroup.LayoutParams.MATCH_PARENT
            )

            settings.apply {
              javaScriptEnabled = true
              domStorageEnabled = true
              allowFileAccess = true
              allowContentAccess = true
              loadWithOverviewMode = true
              useWideViewPort = true
              cacheMode = WebSettings.LOAD_DEFAULT
              displayZoomControls = false
              builtInZoomControls = false
            }

            webChromeClient = WebChromeClient()

            webViewClient = object : WebViewClient() {
              override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                isLoading = true
              }

              override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                isLoading = false
                canGoBack = view?.canGoBack() ?: false
              }

              override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
              ): Boolean {
                val url = request?.url?.toString() ?: return false
                if (url.startsWith("mailto:")) {
                  val intent = Intent(Intent.ACTION_SENDTO, Uri.parse(url))
                  try {
                    ctx.startActivity(intent)
                  } catch (e: Exception) {
                    Toast.makeText(ctx, "No se encontró cliente de correo: $url", Toast.LENGTH_SHORT).show()
                  }
                  return true
                }
                return false
              }
            }

            loadUrl("file:///android_asset/web/index.html")
            webViewInstance = this
          }
        },
        update = { webView ->
          webViewInstance = webView
        },
        modifier = Modifier
          .fillMaxSize()
          .testTag("webview_portal")
      )

      if (isLoading) {
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(DarkBg.copy(alpha = 0.5f)),
          contentAlignment = Alignment.Center
        ) {
          CircularProgressIndicator(
            color = GoogleBlue,
            modifier = Modifier.size(48.dp)
          )
        }
      }
    }
  }

  // Dialog with One-Click URLs for Google Play Console Submission
  if (showUrlsDialog) {
    GooglePlayUrlsDialog(
      onDismiss = { showUrlsDialog = false },
      context = context
    )
  }
}

@Composable
fun QuickNavChip(label: String, onClick: () -> Unit) {
  FilterChip(
    selected = false,
    onClick = onClick,
    label = {
      Text(
        text = label,
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium
      )
    },
    colors = FilterChipDefaults.filterChipColors(
      containerColor = DarkSurface,
      labelColor = Color(0xFFE2E8F0)
    ),
    border = FilterChipDefaults.filterChipBorder(
      enabled = true,
      selected = false,
      borderColor = DarkBorder
    )
  )
}

@Composable
fun GooglePlayUrlsDialog(onDismiss: () -> Unit, context: Context) {
  val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

  fun copyToClipboard(label: String, text: String) {
    val clip = ClipData.newPlainText(label, text)
    clipboard.setPrimaryClip(clip)
    Toast.makeText(context, "$label copiado al portapapeles", Toast.LENGTH_SHORT).show()
  }

  AlertDialog(
    onDismissRequest = onDismiss,
    title = {
      Text(
        text = "URLs para Google Play Console",
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
      )
    },
    text = {
      Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(
          text = "Rutas obligatorias para la verificación de desarrollador y cumplimiento de fichas de Play Store:",
          fontSize = 12.sp,
          color = Color(0xFF94A3B8)
        )

        PlayUrlItem(
          label = "Sitio Web de Desarrollador",
          url = "https://tenochgiron.dev",
          onCopy = { copyToClipboard("Sitio Web", "https://tenochgiron.dev") }
        )

        PlayUrlItem(
          label = "Política de Privacidad (ChefMágico)",
          url = "https://tenochgiron.dev/#privacy-chef",
          onCopy = { copyToClipboard("Privacidad ChefMágico", "https://tenochgiron.dev/#privacy-chef") }
        )

        PlayUrlItem(
          label = "Política de Privacidad (Emociona)",
          url = "https://tenochgiron.dev/#privacy-emociona",
          onCopy = { copyToClipboard("Privacidad Emociona", "https://tenochgiron.dev/#privacy-emociona") }
        )

        PlayUrlItem(
          label = "Eliminación de Cuenta / Datos (Data Safety)",
          url = "https://tenochgiron.dev/#data-deletion",
          onCopy = { copyToClipboard("URL Borrado de Datos", "https://tenochgiron.dev/#data-deletion") }
        )

        PlayUrlItem(
          label = "app-ads.txt (Google AdMob)",
          url = "https://tenochgiron.dev/app-ads.txt",
          onCopy = { copyToClipboard("URL app-ads.txt", "https://tenochgiron.dev/app-ads.txt") }
        )
      }
    },
    confirmButton = {
      TextButton(onClick = onDismiss) {
        Text("Cerrar", color = GoogleBlue, fontWeight = FontWeight.Bold)
      }
    },
    containerColor = DarkSurface,
    titleContentColor = Color.White
  )
}

@Composable
fun PlayUrlItem(label: String, url: String, onCopy: () -> Unit) {
  Card(
    colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
    shape = RoundedCornerShape(8.dp),
    modifier = Modifier.fillMaxWidth()
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 8.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Column(modifier = Modifier.weight(1f)) {
        Text(
          text = label,
          fontSize = 11.sp,
          fontWeight = FontWeight.SemiBold,
          color = Color(0xFF38BDF8)
        )
        Text(
          text = url,
          fontSize = 10.sp,
          color = Color(0xFF94A3B8),
          maxLines = 1
        )
      }
      IconButton(onClick = onCopy, modifier = Modifier.size(32.dp)) {
        Icon(
          imageVector = Icons.Default.ContentCopy,
          contentDescription = "Copiar",
          tint = Color(0xFFCBD5E1),
          modifier = Modifier.size(16.dp)
        )
      }
    }
  }
}

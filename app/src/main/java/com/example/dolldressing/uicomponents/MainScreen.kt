package com.example.dolldressing.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolldressing.R
import com.example.dolldressing.model.DollViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: DollViewModel = viewModel()
) {
    val dollComponent = viewModel.dollComponent
    val visibilityStates = viewModel.visibilityStates
    val orientation = LocalConfiguration.current.orientation
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "202112344 이현지",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.body),
                        contentDescription = "body",
                        modifier = Modifier
                            .matchParentSize()
                            .zIndex(0f)
                    )
                    dollComponent.forEachIndexed { index, name ->
                        if (visibilityStates[name] == true) {
                            Image(
                                painter = painterResource(id = getDrawableId(name)),
                                contentDescription = name,
                                modifier = Modifier
                                    .matchParentSize()
                                    .zIndex((index + 1).toFloat())
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(modifier = Modifier.fillMaxWidth()) {
                    dollComponent.chunked(2).forEach { rowItems ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            rowItems.forEach { name ->
                                Row(
                                    modifier = Modifier.padding(end = 32.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = visibilityStates[name] == true,
                                        onCheckedChange = { viewModel.toggleVisibility(name, it) }
                                    )
                                    Text(name)
                                }
                            }
                        }
                    }
                }
            }
        } else {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(400.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.body),
                        contentDescription = "body",
                        modifier = Modifier
                            .matchParentSize()
                            .zIndex(0f)
                    )
                    dollComponent.forEachIndexed { index, name ->
                        if (visibilityStates[name] == true) {
                            Image(
                                painter = painterResource(id = getDrawableId(name)),
                                contentDescription = name,
                                modifier = Modifier
                                    .matchParentSize()
                                    .zIndex((index + 1).toFloat())
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.Start
                ) {
                    dollComponent.chunked(2).forEach { rowItems ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            rowItems.forEach { name ->
                                Row(
                                    modifier = Modifier.padding(end = 32.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = visibilityStates[name] == true,
                                        onCheckedChange = { viewModel.toggleVisibility(name, it) }
                                    )
                                    Text(name)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun getDrawableId(name: String): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(name, "drawable", context.packageName)
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}

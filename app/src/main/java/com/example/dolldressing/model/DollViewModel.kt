package com.example.dolldressing.model

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel

class DollViewModel : ViewModel() {
    val dollComponent = listOf(
        "arms", "ears", "eyebrows", "eyes", "glasses",
        "hat", "mouth", "mustache", "nose", "shoes"
    )

    val visibilityStates = mutableStateMapOf<String, Boolean>().apply {
        dollComponent.forEach { this[it] = false }
    }

    fun toggleVisibility(name: String, visible: Boolean) {
        visibilityStates[name] = visible
    }
}

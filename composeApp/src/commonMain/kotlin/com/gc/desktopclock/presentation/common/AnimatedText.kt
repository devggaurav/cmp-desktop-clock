package com.gc.desktopclock.presentation.common

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle


//
// Created by Code For Android on 28/02/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedCounter(
    count: Int,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.headlineLarge,
    increment: Boolean = true
) {

    var oldCount by remember {
        mutableStateOf(count)
    }


    SideEffect {
        oldCount = count
    }

    Row(modifier = modifier) {
        val countString = count.toString()
        val oldCountString = oldCount.toString()

        for (i in countString.indices) {

            val oldChar = oldCountString.getOrNull(i)
            val newChar = countString[i]

            val char = if (oldChar == newChar) {
                oldCountString[i]
            } else {
                countString[i]
            }
            if (increment) {
                AnimatedContent(targetState = char,
                    transitionSpec =
                    { slideInVertically { it } togetherWith slideOutVertically { -it } }
                ) { txt ->
                    Text(text = txt.toString(), style = style, softWrap = false,

                    )
                }
            } else {
                AnimatedContent(targetState = char,
                    transitionSpec =
                    { slideInVertically { -it } togetherWith slideOutVertically { it } }
                ) { txt ->
                    Text(text = txt.toString(), style = style, softWrap = false
                    ,
                    )
                }

            }

        }

    }


}
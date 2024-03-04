package com.example.oechappfinal.ui.screen.onboarding

import androidx.lifecycle.ViewModel
import com.example.oechappfinal.R
import com.example.oechappfinal.data.application.ApplicationContext
import com.example.oechappfinal.data.Storage
import com.example.oechappfinal.data.model.Onboarding
import java.util.LinkedList
import java.util.Queue

class OnboardingViewModel(): ViewModel() {
    private var onboardings: Queue<Onboarding> = LinkedList()

    fun setOnboardItems(items: Queue<Onboarding>) {
        onboardings = items
    }

    fun getOnboardItems(): Queue<Onboarding> {
        return onboardings
    }

    fun getIdOfOnboardingScreen(): Int {
        val storage = Storage(ApplicationContext.getContext())
        return storage.idOfOnboardingScreen
    }

    fun setIdOfOnboardingScreen(screenId: Int) {
        val storage = Storage(ApplicationContext.getContext())
        storage.idOfOnboardingScreen = screenId
    }
}

data class OnboardingData(
    val onboardings: Queue<Onboarding> = if (Storage(ApplicationContext.getContext()).idOfOnboardingScreen == 0) {
            LinkedList(
                listOf(
                    Onboarding(
                        imageResId = R.drawable.onboarding_screen_first_image,
                        titleTextResId = R.string.OnboardingFirstTitle,
                        descriptionTextResId = R.string.OnboardingFirstDescription,
                    ),
                    Onboarding(
                        imageResId = R.drawable.onboarding_screen_second_image,
                        titleTextResId = R.string.OnboardingSecondTitle,
                        descriptionTextResId = R.string.OnboardingSecondDescription,
                    ),
                    Onboarding(
                        imageResId = R.drawable.onboarding_screen_third_image,
                        titleTextResId = R.string.OnboardingThirdTitle,
                        descriptionTextResId = R.string.OnboardingThirdDescription,
                    )
                )
            )
        } else if (Storage(ApplicationContext.getContext()).idOfOnboardingScreen == 1) {
            LinkedList(
                listOf(
                    Onboarding(
                        imageResId = R.drawable.onboarding_screen_second_image,
                        titleTextResId = R.string.OnboardingSecondTitle,
                        descriptionTextResId = R.string.OnboardingSecondDescription,
                    ),
                    Onboarding(
                        imageResId = R.drawable.onboarding_screen_third_image,
                        titleTextResId = R.string.OnboardingThirdTitle,
                        descriptionTextResId = R.string.OnboardingThirdDescription,
                    )
                )
            )
        } else if (Storage(ApplicationContext.getContext()).idOfOnboardingScreen == 2) {
            LinkedList(
                listOf(
                    Onboarding(
                        imageResId = R.drawable.onboarding_screen_third_image,
                        titleTextResId = R.string.OnboardingThirdTitle,
                        descriptionTextResId = R.string.OnboardingThirdDescription,
                    )
                )
            )
        } else {
            LinkedList()
        }
)
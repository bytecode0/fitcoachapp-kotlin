enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "fitcoachapp-kotlin"

include(
    ":android",
    ":desktop",
    ":fitcoachapp-app",
    ":fitcoachapp-feature-auth",
    ":fitcoachapp-feature-onboarding",
    ":fitcoachapp-feature-dashboard",
    ":fitcoachapp-feature-exercises",
    ":fitcoachapp-feature-workout",
    ":fitcoachapp-feature-profile",
    ":fitcoachapp-payment",
    ":fitcoachapp-firebase",
    ":fitcoachapp-openai-api"
)

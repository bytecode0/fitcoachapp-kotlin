enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "fitcoachapp-kotlin"

include(
    ":android",
    ":fitcoachapp-app",
    ":fitcoachapp-feature-auth-ui",
    ":fitcoachapp-feature-auth-domain",
    ":fitcoachapp-feature-auth-firebase",
    ":fitcoachapp-feature-onboarding",
    ":fitcoachapp-feature-dashboard",
    ":fitcoachapp-feature-exercises",
    ":fitcoachapp-feature-workout",
    ":fitcoachapp-feature-profile",
    ":fitcoachapp-payment",
    ":fitcoachapp-openai-api"
)

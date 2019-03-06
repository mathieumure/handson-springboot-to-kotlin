module.exports = {
    title: "Spring boot to Kotlin",
    description: "Migration d'un projet spring boot de java vers Kotlin",
    base: "/handson-springboot-to-kotlin/",
    port: 3000,
    themeConfig: {
        // Assumes GitHub. Can also be a full GitLab url.
        repo: 'mathieumure/handson-springboot-to-kotlin',
        // defaults to false, set to true to enable
        editLinks: true,
        // custom text for edit link. Defaults to "Edit this page"
        editLinkText: 'Help us improve this page!',
        // if your docs are not at the root of the repo:
        docsDir: 'tps',
        sidebar: [
            '/GETTING_STARTED',
            '/API'
        ]
    }
};
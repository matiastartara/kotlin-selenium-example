# kotlin-selenium-example

This repository is a small example showing how to use Selenium WebDriver with Kotlin to automate web UI tests. It is intended as a reference to:

- Demonstrate the minimal structure of a Kotlin + Maven test project.
- Show a basic Page Object pattern using the files under `src/main/kotlin/pages`.
- Provide utilities to initialize the WebDriver in `src/main/kotlin/utils/Driver.kt` and example tests under `src/test/kotlin`.

Index
-----

- [Requirements](#requirements)
- [Installation and running](#installation-and-running)
- [Configuration](#configuration)
- [Project structure](#project-structure)
- [Quick example](#quick-example)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

Requirements
------------

- JDK 17 or newer (JDK 17 recommended).
- Maven 3.x.
- A supported browser (e.g. Google Chrome) and the corresponding driver (e.g. ChromeDriver) unless you use an automatic driver manager.

Installation and running
------------------------

1. Clone the repository:

```bash
git clone https://github.com/matiastartara/kotlin-selenium-example.git
cd kotlin-selenium-example
```

2. Build the project:

```bash
mvn clean install
```

3. Run the tests:

```bash
mvn test
```

Run a specific test class (for example `LoginTest`):

```bash
mvn -Dtest=LoginTest test
```

Configuration
-------------

The project loads configuration from `src/main/resources/config.properties`. A generated copy is also available under `target/classes` when the project is built. Typical properties include the base URL, timeouts and browser settings.

Example minimal `config.properties` (already present in the project):

```properties
base.url=https://example.com
browser=chrome
implicit.wait=10
```

If you use a local driver binary (e.g. `chromedriver`), ensure it is on your PATH or configure the path in your system or inside `utils/Driver.kt`.

Project structure
-----------------

Top-level overview:

- `pom.xml` — Maven configuration and dependencies.
- `src/main/kotlin/` — main sources:
  - `pages/` — Page Objects (`BasePage.kt`, `HomePage.kt`).
  - `utils/Driver.kt` — WebDriver initialization and management.
  - `UtilResources.kt` — helper to load resources/properties.
- `src/test/kotlin/` — tests (e.g. `BaseTest.kt`, `LoginTest.kt`).

Quick example
-------------

The test `LoginTest.kt` demonstrates how to initialize the driver, navigate to a page and use Page Objects to perform assertions. Run `mvn test` to execute the tests.

Troubleshooting
---------------

- Error: "WebDriverException: unknown error: cannot find Chrome binary" — Make sure Chrome is installed or configure the path to the browser executable.
- Error: "The path to the driver executable must be set" — Put `chromedriver` on the PATH or configure its location in `Driver.kt`.
- macOS (Apple Silicon / M1): download the correct ChromeDriver build for your architecture and give it execution permissions: `chmod +x /path/to/chromedriver`.

Contributing
------------

Pull requests are welcome. For larger changes, open an issue first to discuss the approach. Keep tests passing and add tests for new functionality.

License
-------

This project does not include an explicit license file. If you plan to publish or share it, consider adding a `LICENSE` file (for example, MIT).

Contact
-------

If you need help with the project open an issue or contact the maintainer of the repository.

---

Optional additions I can make for you:

- Add instructions to run tests in headless mode or in parallel (useful for CI).
- Add an example `config.properties` setup for multiple environments (dev/ci/prod).
- Add a `run-tests.sh` script or a simple `Makefile` to simplify common commands.

Tell me which of these you want and I will add it.

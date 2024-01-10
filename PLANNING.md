# Planning Document

## Roadmap

In order to get the most value of the product early, this project launches in a set of milestones. Each milestone unlocks additional value.

### M1: Workshops 'lite'

The first milestone allows users to sign up and login, and then to create **public** workshops. In addition, users will be able to browse and sign up for workshops. In this milestone, organizers can provide details about requirements for their workshop, such as materials, but also other requirements such as age requirements or allergy requirements. Users will be able to set up requirements in their profile, too, such as allergies and inventory they own. Once people signed up for a workshop, they get access to a workshop specific chat room where they can discuss the workshop.

**Values unlocked:**

- building a community
- users getting familiar with product
- freemium model allows for strong initial adoption
- adoption and usage metrics can be gathered early and be used for iterative product design

**Consists of**:

- User Signup flow
- User login flow
- UI pages such as browsing workshops, workshop CRUC flow (Create, Read, Update, Cancel) and basic chatting, integrated with backend
- backend with REST API for auth and user/workshop endpoints
- Google Analytics Integration
- entity auditing

### M2: Private workshops

Once M1 has been rolled out, a community starts to build and we can start sending newsletters about the development of amazing new features we are currently working on, one of which will be **Private Workshops**. A private workshop is a workshop that is not publicly visible/searchable but a link can be shared/sent around, including RSVP support. By signing up for our **Workshop Basic** subscription plan, users get the ability to set up private workshops. The subscription will be tiered later on but initially, the 'basic' subscription plan allows us to charge not as much to begin with but later introduce more sophisticated tiers with additional, amazing features. This launches in a english speaking country first to simplify tax process for payments and language support.

**Values unlocked:**

- subscription allows for early cashflow
- users get familiar with freemium model and build a tolerance towards it
- further usage metrics can give us insights on % of subscriptions
- in-app & email notifications

**Consists of:**

- subscription flow + subscription backend API
- payment integration
- private workshops
- RSVP flow (via email & in app notification)

## M3: AI onboarding & Interests

This milestone allows users to customize a set of interests and discover public workshops for it. The onboarding process for users will be improved by providing an alternative way to sign up: the meetup chat bot. This GPT driven bot will ask questions about the users interests, to grasp the intentions of the user. This can also be used to gather feedback early for features that we may not support yet. Once the bot has gathered enough information, it will preconfigure interests for the user (potentially generate new ones too) and will recommend public workshops for you. A premium feature will be a chat bot version for organizers, that allows them to generate workshops for them. Additionally, this milestone introduces a new premium feature will be the discovery of users who might be interested in your workshop (public or private). Users are opt-in by default to be discoverable but can opt-out to be discovered if they wish to.

**Values unlocked:**

- more reasons to subscribe to premium
- AI integration unlocks new values and we can start building an 'interest graph' of our community which we can harness later on
- less friction during onboarding improves signup rate. Talking to a bot is less formal than 'filling out a form' and submitting it.

**Consists of:**

- GPT API chat integration
- dynamic interest graph

## M4: Gamification & Social Improvements

This milestone also starts gamifying the product by introducing workshop points & leagues. Gaining enough points during a month allows to rise up to the next league. Successfully attending a workshop grants the user points that get attributed not only to the user but also are assigned to the interests of the workshop they attended. People can view the league system and filter by interests to discover amazing people.
To further improve ways to build stronger communities, additional social features are built such as friend system (one can see which public workshops your friends attend) and private messages.

**Values unlocked:**

- stronger community growth through improved discoverability and social features
- more reasons to sign up for premium: people who might have struggled setting up a private workshop will now be able to do so more easily now
- people have reasons to come back to the app and check in on their leaderboard. This should positively impact our DAU figures.

**Consists of:**

- Points & League Flow
- Private chat system
- Friend system & notifications

## M5: tenant system & global launch

This milestone will unlock additional revenue streams by launching in more countries + supporting other languages. Subscription prices are adjusted for specific regions accordingly, to consider inflation. A new premium subscription tier (fixed yearly rate per X seats) for businesses is introduced. This allows businesses to have their own tenant and manage their own company internal private workshops. This milestone also allows for user import support to sync users, e.g. through workday and Active Directory. This means that users will be able to access our platform through their company internal signup system without the need to create accounts. Also, users leaving that business would be auto-removed from the platform.

## Team Composition

> Disclaimer: The team composition assumes that this product is being built as part of a small startup that already hired other functions such as HR, Sales and Marketing. This composition focuses purely on the development & rollout of this feature. This also assumes all employees work remotely to save office cost and allow for a more diverse hiring pool.

**The Team:**

- **Senior Product Engineer**: Responsible for organising stakeholder demos and keeping the backlog in shape and order. Will be in close collaboration with both the **Techlead** but also **Sales** and **Marketing** to ensure rollout of features is communicated properly. Should have experience with community building and organizing workshops already. A plus here would be some technical knowledge with UX design and SQL (but not a must). Also, should bring UX experience and be able to produce designs and give direct input on pull requests for any given feature.
- **Techlead**: responsible for collaborating closely with the product owner to ensure architecture and domain design is aligned with product needs. Also, responsible for identifying bottlenecks during development of features. Also writes code on a daily basis, especially during the beginning of the project.
- **2x Software Engineer (Senior)**: responsible for building the backend system and frontend, including the API Gateway and REST contract, entity service and database setup. Also, responsible for setting up cloud infrastructure. Works closely together with **Techlead**. Should be interested in product development too and not shy away from talking to the product owner or UX designer.

**Explanation:**

The idea is to minimise time to market and maximise velocity. Therefore, time cannot spent on mentoring and onboarding originally, so the team will be kept small but efficient. To avoid disruption due to illness or other factors, there are a total of 3 engineers required. This is crucial, especially for QA purposes.

Also note that there are some familiar roles missing here: this team does not hire a dedicated **QA engineer** but instead engineers will ensure through automated end-to-end tests that the quality of the product is ensured. Another role not present is a **DevOps engineer** - engineers of this team will be responsible to setup the infrastructure themselves.

## Technology considerations

### Goals

The following goals are considered for the technologies chosen:

1. fast development cycles: Classical handover between 'frontend' and 'backend' should be avoided
2. not too many technologies: hiring is more difficult if too many exotic programming languages are being employed
3. mature ecosystem: while fancy new tech feels nice to work with, the goal here is to create robust (and resilient) software. Therefore, the technologies chosen should come with a mature ecosystem underneath, meaning that there is community support, good documentation, stable releases and quick time to address security issues
4. easy to maintain: the technologies should all be maintainable in code, as anything that is committed to a repository can be shared, and changes have a track record. This means that the goal is to maximise the setup in version control and minimise manual setup

### Technology Stack

- **React** to allow for consistent state in the UI, [React](https://react.dev/) is being employed
- **Tailwind.css** for fast styling of components. It is especially great for trying out new ideas very quickly, without having to navigate through .scss or .sass files
- **Typescript** for type-safety. While initially, vanilla JS may be faster to write, [typescript](https://www.typescriptlang.org/) comes with a great ecosystem and allows for **Documentation As Code**. Also, Javascript is a widely known programming languages and many fullstack/Java engineers know Javascript, too.
- **Github**: all repositories will be stored in a dedicated Github organization. Some useful features that allow us to move fast: Github actions, Github packages, Github project management and issue tracking (for kanban board)
  - **Github Packages** we may depend on custom tools and libraries that we do not want to expose to the internet. [Github packages](https://github.com/features/packages) in private repos will allow us to push docker images and .jar dependencies to it so we can use them internally.
- **Docker**: docker is used for local development but also to push images to [Github packages](https://github.com/features/packages). However, developers will use [Rancher](https://www.rancher.com/) locally rather than **Docker for Desktop** to dodge the Docker fees.
- **Java 21 + Spring Boot 3** Java is a powerful programming language with [customizable garbage collection](https://www.baeldung.com/jvm-garbage-collectors), a very mature ecosystem and modern language features thanks to [Java 21](https://blogs.oracle.com/java/post/the-arrival-of-java-21).
  - **Jib** to build docker images without a docker daemon. [Jib](https://cloud.google.com/java/getting-started/jib) is a powerful tool invented by Google that allows you to build + push optimised Java images without the need to setup docker on your CI environment.
  - **Gradle** for dependency management. [Gradle](https://gradle.org/) is the defacto Gold standard of dependency management in Java and similar to npm is responsible for downloading and syncing dependencies.
- **Terraform** for infrastructure setup: [Terraform](https://www.terraform.io/) is powerful to maintain any infrastructure at scale and shall be used to store Infrastructure as Code.
- **Vault** this project requires storing a lot of secret information, such as API keys and credentials. Those should never be committed to version control - instead, it will be stored in [Vault](https://www.vaultproject.io/) which Terraform neatly integrates with.
- **MySQL 8** this product uses MySQL 8 which comes with powerful indexing algorithms and is natively supported by Amazon RDS.
- **Amazon Web Services** this project will be deployed to Amazon Web Services. With its cloud architecture we can deploy our stack into various datacenter regions all around the globe to minimise latency. Originally using the `eu-west-1` location:
  - [AWS Fargate](https://docs.aws.amazon.com/AmazonECS/latest/userguide/what-is-fargate.html) for containerization of apps. Fargate is slightly more expensive than ECS (but can be still cheaper than running a fully fledged Kubernetes cluster):
    1. no need to manage any infrastructure. This also means no need to manage scaling EC2 groups up or down depending on load. Fargate manages that
    2. faster setup. Rather than spending time both building a complicated deployment setup, Fargate takes away that pain
    3. neat integration into other AWS services: we want to potentially harness other services such as Amazon S3 for blob storage, Route53 for domain routing setup and EC2 for load balancing and WAF DDOS protection
  - [WAF](https://aws.amazon.com/waf/) by Amazon allows us to get DDOS protection out of the box. This also ensures that our backend only processes requests that are actually useful and improves security.
  - [Virtual Private Cloud (VPC)](https://docs.aws.amazon.com/vpc/latest/userguide/what-is-amazon-vpc.html) is used for subnetting and configuring our IP ranges for the services.
  - [Amazon RDS](https://aws.amazon.com/free/database) is used as our database solution of choice, configured with MySQL 8.
  - [Amazon Neptune](https://aws.amazon.com/neptune/) is a powerful graph-database that we can utilise to build our interests graph of all our users and make smart decisions about it.
  - [Amazon Amplify](https://aws.amazon.com/amplify/authentication/) amplify allows for user management and authentication, including [React client](https://docs.amplify.aws/react/start/getting-started/introduction/) and JWT authentication and verification [through Cognito](https://docs.aws.amazon.com/cognito/latest/developerguide/amazon-cognito-user-pools-using-tokens-verifying-a-jwt.html).
  - [Amazon Cloudwatch](https://aws.amazon.com/cloudwatch/) is used to push application logs to by the applications. This is especially important to debug production issues, e.g. by enriching logs with trace ids.
  - [Amazon Prometheus](https://aws.amazon.com/prometheus/) is a powerful tool for application monitoring. While we use Cloudwatch to get detailed logs, we want to also be able to have dashboards & metrics on our application behaviour, as well as alerting via [Alert Manager](https://prometheus.io/docs/alerting/latest/alertmanager/).
- **Grafana** for application dashboards and highlighting important metrics. It also integrates into Google Analytics and Prometheus, allowing us to cross-reference events and behaviour, e.g. during an outage we can see in realtime what impact that might have on user behaviour.
- **GPT OpenAPI** access is required so we can utilise its API for our custom chatbot.
- **Google Analytics** is used for reporting on user metrics and usage behaviour. [Google Analytics](https://marketingplatform.google.com/intl/en_uk/about/analytics/) is set up in the frontend (with opt-in cookie consent banner) to send usage metrics to Google that will be useful to us to make UX decisions.
- **PagerDuty** (optional) once we have configured alerts via AlertManager in Prometheus, we also want to know when our app goes down. This becomes especially important once we launch in multiple regions, as there could be issues at 3am local time and one of our engineers would need to be woken up to have a look.

### Development Approach

- Milestone based kanban style
- Developers write and pickup tickets themselves with assistance of Product Engineer to prioritise things
- Programming principles to be considered: Clean Code where applicable (pragmatic approach, not theoretical approach), prefer component testing (snapshots) & e2e over unit testing to save time but write unit tests for critical components where needed. Composition over inheritance. Avoid design patterns and over engineering if possible - keep it simple!
- Environments: we will follow a promotional build strategy where we deploy features from a dev environment into a staging environment and then deploy to production.

## Time / scope / budget planning

### Costs

> Note: for the sake of this exercise and to keep things simple, all salary costs are average salaries paid in United Kingdom, sourced from [Glassdoor](https://www.glassdoor.co.uk/Salaries). Prices are converted to USD using [Xe](https://www.xe.com/currencyconverter/).
>
> ChatGPT has been used to calculate the rough estimation figure for the AWS Cloud bill, assuming DAU of 10000 with 100-150 requests per day.
>
> ChatGPT has been used to calculate the rough estimation figure for the OpenAI bill, 1000 users interacting with the chat bot on a daily basis with a conversation length of 1 minute.

This project breaks down costs as follows:

| Category | Description              | Estimated Cost (per year) | Notes                                 |
| -------- | ------------------------ | ------------------------- | ------------------------------------- |
| Salary   | Senior Product Engineer  | $79k                      |                                       |
| Salary   | Techlead                 | $120k                     |                                       |
| Salary   | Senior Software Engineer | $100k                     |                                       |
| Salary   | Senior Software Engineer | $100k                     |                                       |
| License  | PagerDuty                | $0                        | Free Plan (up to 5 users)             |
| License  | Google Analytics         | $0                        | Free                                  |
| License  | Github                   | $200                      | Team Plan ($4 per user/month)         |
| Cost     | Github                   | $500                      | Github usage.                         |
| Cost     | AWS                      | $35k                      | rough estimation of yearly cloud bill |
| Cost     | OpenAI                   | $30k                      |                                       |

**Grand Total**: $364k per year. To be pessimistic, we can double this figure, equalling to roughly $700k. Given a joined pre-seed and seed funding of $2M, this would give us a runway of 2 years.

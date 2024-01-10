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

Disclaimer: The team composition assumes that this product is being built as part of a small startup that already hired other functions such as HR, Sales and Marketing. This composition focuses purely on the development & rollout of this feature.

**The Team:**

- **Product Owner**: Responsible for organising stakeholder demos and keeping the backlog in shape and order. Will be in close collaboration with both the **Techlead** but also **Sales** and **Marketing** to ensure rollout of features is communicated properly. Should have experience with community building and organizing workshops already. A plus here would be some technical knowledge with UX design and SQL (but not a must).
- **Techlead**: responsible for collaborating closely with the product owner to ensure architecture and domain design is aligned with product needs. Also, responsible for identifying bottlenecks during development of features.
- **2x Senior Engineer**: responsible for building the backend system and frontend, including the API Gateway and REST contract, entity service and database setup. Also, responsible for setting up cloud infrastructure. Works closely together with **Techlead**

## Time / scope / budget planning

todo

## Technology considerations

todo
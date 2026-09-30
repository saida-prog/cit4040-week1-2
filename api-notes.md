# API Notes — GitHub REST API

API chosen: GitHub REST API (https://docs.github.com/en/rest), base URL https://api.github.com

## Three endpoints

1. GET /users/{username} — returns a JSON object describing a public user profile
   (login, id, name, public_repos, followers, created_at, ...).
2. GET /repos/{owner}/{repo} — returns one repository as a JSON object
   (name, full_name, description, stargazers_count, default_branch, ...).
3. POST /user/repos — creates a new repository for the signed-in user; the body is JSON
   with at least "name". Returns 201 Created and the new repository object.

## Why these HTTP methods make sense

The first two only read data and change nothing on the server, so GET is the right
choice: it is safe, can be repeated, and can be cached. Creating a repository adds a
new resource, so POST fits — each call creates something new and it needs a request
body with the data. It also requires authentication (a token), while the GET calls
work anonymously for public data.

## What happens when something does not exist

The docs say the API answers with status 404 Not Found and a small JSON body. I tested
GET /repos/octocat/this-repo-does-not-exist-123 and got HTTP 404 with:

    {"message": "Not Found", "documentation_url": "...", "status": "404"}

The docs also note GitHub returns 404 (not 403) for private resources you are not
allowed to see, so it does not reveal that they exist.

## Task 1.1 — DevTools observation

Site: en.wikipedia.org (article "Java (programming language)")

Request 1 — the page itself
- Method: GET
- Path: /wiki/Java_(programming_language)
- Header 1: user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) ... Chrome/152 ...
- Header 2: accept: text/html,application/xhtml+xml,...
- Has a body? No — GET requests only ask for data, so there was no Payload tab.
- Response: 200 OK, an HTML page.

Request 2 — a JSON response (sent when hovering a link to show the page preview)
- Method: GET
- Path: /api/rest_v1/page/summary/Sun_Microsystems
- Response header content-type: application/json; charset=utf-8
- Response header cache-control: s-maxage=1209600, max-age=300
- Two JSON field names: "title" ("Sun Microsystems") and "extract" (a short summary of the article).
  Other fields included "pageid", "description" and "thumbnail".

I also saw a POST to /ins-502b/v2/events (status 202 Accepted) — this one does have a
body, because it sends analytics events to the server.

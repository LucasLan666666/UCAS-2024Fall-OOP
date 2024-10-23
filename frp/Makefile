export PATH := $(PATH):`go env GOPATH`/bin # 将GOPATH/bin目录加入到PATH中
export GO111MODULE=on # 开启go mod支持
LDFLAGS := -s -w # 减少二进制文件大小

all: env fmt build

build: frps frpc

env:
	@go version

# compile assets into binary file
# 用于将web资源编译到二进制文件中
file:
	rm -rf ./assets/frps/static/*
	rm -rf ./assets/frpc/static/*
	cp -rf ./web/frps/dist/* ./assets/frps/static
	cp -rf ./web/frpc/dist/* ./assets/frpc/static

fmt:
	go fmt ./...

fmt-more:
	gofumpt -l -w .

gci:
	gci write -s standard -s default -s "prefix(github.com/fatedier/frp/)" ./

vet:
	go vet ./...

frps:
	env CGO_ENABLED=0 go build -trimpath -ldflags "$(LDFLAGS)" -tags frps -o bin/frps ./cmd/frps

frpc:
	env CGO_ENABLED=0 go build -trimpath -ldflags "$(LDFLAGS)" -tags frpc -o bin/frpc ./cmd/frpc

test: gotest

gotest:
	GO111MODULE=on go test -v --cover ./assets/...
	GO111MODULE=on go test -v --cover ./cmd/...
	GO111MODULE=on go test -v --cover ./client/...
	GO111MODULE=on go test -v --cover ./server/...
	GO111MODULE=on go test -v --cover ./pkg/...

e2e:
	./hack/run-e2e.sh

e2e-trace:
	DEBUG=true LOG_LEVEL=trace ./hack/run-e2e.sh

e2e-compatibility-last-frpc:
	if [ ! -d "./lastversion" ]; then \
		TARGET_DIRNAME=lastversion ./hack/download.sh; \
	fi
	FRPC_PATH="`pwd`/lastversion/frpc" ./hack/run-e2e.sh
	rm -r ./lastversion

e2e-compatibility-last-frps:
	if [ ! -d "./lastversion" ]; then \
		TARGET_DIRNAME=lastversion ./hack/download.sh; \
	fi
	FRPS_PATH="`pwd`/lastversion/frps" ./hack/run-e2e.sh
	rm -r ./lastversion

alltest: vet gotest e2e

clean:
	rm -f ./bin/frpc
	rm -f ./bin/frps
	rm -rf ./lastversion
